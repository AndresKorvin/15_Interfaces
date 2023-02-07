package org.example;

public class Repository {
    private Ticket[] tickets = new Ticket[0];
    protected Repository(Ticket[] tickets) {
        this.tickets = tickets;
    }

    protected Ticket[] findAll() {
        return tickets;
    }

    protected Ticket findById(int id) {
        for (Ticket tick :
                tickets) {
            if (id == tick.getId()) return tick;
        } return null;
    }

    protected void saveTicket(Ticket ticket) {
        Ticket tmpTick = findById(ticket.getId());
        if (tmpTick != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + tmpTick.getId() + " already exists"
            );
        }

        Ticket[]  tmp = new Ticket[tickets.length + 1];
        int cnt = 0;
        for (Ticket tick: tickets
        ) {
            tmp[cnt] = tick;
            cnt++;
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    protected void removeById(int idProduct) {
        Ticket prod = findById(idProduct);
        if (prod == null) {
            throw new NotFoundException (
                    "Element with id: " + idProduct + " not found"
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int cnt = 0;
        for (Ticket product: tickets
        ) {
            if (product.getId() != idProduct) {
                tmp[cnt] = product;
                cnt++;
            }
        }
        tickets = tmp;
    }
}