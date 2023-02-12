package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ManagerTest {
    Ticket ticket1 = new Ticket(1, 600, "London", "Paris", 61);//
    Ticket ticket2 = new Ticket(2, 800, "Prague", "Dublin", 85);
    Ticket ticket3 = new Ticket(3, 900, "Prague", "Dublin", 96);
    Ticket ticket4 = new Ticket(4, 500, "London", "Paris", 38);//
    Ticket ticket5 = new Ticket(5, 400, "Paris", "Dublin", 55);
    Ticket ticket6 = new Ticket(6, 300, "London", "Paris", 73);//
    Ticket ticket7 = new Ticket(7, 350, "London", "Dublin", 102);
    Ticket ticket8 = new Ticket(8, 450, "London", "Paris", 95);//
    Ticket ticket9 = new Ticket(9, 650, "London", "Paris", 81);//
    Ticket ticket10 = new Ticket(10, 750, "London", "Prague", 68);

    @ParameterizedTest
    @CsvSource({
            "London, Paris",
            "Lon, Paris",
            "London, Par",
            "don, Paris",
            "London, ris",
            "don, ris"
    })
    void searchSomrTicket(String from, String to) {

        Ticket[] tickets = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Repository repository = new Repository(tickets);
        Manager manager = new Manager(repository);
        TicketByTimeComparator service = new TicketByTimeComparator();

        Ticket[] actual = manager.search(from, to, service);
        Ticket[] expected = {ticket4, ticket1, ticket6, ticket9, ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "London, Paris",
            "Lon, Paris",
            "London, Par",
            "don, Paris",
            "London, ris",
            "don, ris"
    })
    void search1Ticket(String from, String to) {

        Ticket[] tickets = new Ticket[]{ticket2, ticket3, ticket5, ticket6, ticket7, ticket10};
        Repository repository = new Repository(tickets);
        Manager manager = new Manager(repository);
        TicketByTimeComparator service = new TicketByTimeComparator();

        Ticket[] actual = manager.search(from, to, service);
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "London, Paris",
            "Lon, Paris",
            "London, Par",
            "don, Paris",
            "London, ris",
            "don, ris"
    })
    void search0Tickets(String from, String to) {

        Ticket[] tickets = new Ticket[]{ticket2, ticket3, ticket5, ticket7, ticket10};
        Repository repository = new Repository(tickets);
        Manager manager = new Manager(repository);
        TicketByTimeComparator service = new TicketByTimeComparator();

        Ticket[] actual = manager.search(from, to, service);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}