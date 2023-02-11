package org.example;

import java.util.Arrays;

public class Manager {
    Repository repository;

    protected Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.saveTicket(ticket);
    }

    protected Ticket[] search(String from, String to) {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[0];
        int cnt = 0;

        for (Ticket tick :
                tickets) {
            if (tick.getFromAirport().contains(from)) {
                if (tick.getToAirport().contains(to)) {

                    cnt++;
                    Ticket[] tmpArr = new Ticket[cnt];
                    for (int i = 0; i < result.length; i++) {
                        tmpArr[i] = result[i];
                    }
                    tmpArr[tmpArr.length - 1] = tick;
                    result = tmpArr;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}