package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Ticket ticket1 = new Ticket(1, 600, "London", "Paris", 3);
    Ticket ticket2 = new Ticket(2, 800, "Prague", "Dublin", 4);
    Ticket ticket3 = new Ticket(3, 900, "Prague", "Dublin", 4);
    Ticket ticket4 = new Ticket(4, 500, "London", "Prague", 3);
    Ticket ticket5 = new Ticket(5, 400, "Paris", "Dublin", 1);
    Ticket ticket6 = new Ticket(6, 300, "London", "Paris", 2);
    Ticket[] tickets = new Ticket[] { ticket1, ticket2, ticket3, ticket4, ticket5, ticket6 };
    Repository repository = new Repository(tickets);
    Manager manager = new Manager(repository);

    @ParameterizedTest
    @CsvSource({
            "London, Paris",
            "Lon, Paris",
            "London, Par",
            "don, Paris",
            "London, ris",
            "don, ris"
    })
    void search(String from, String to) {
        TicketByTimeComparator service = new TicketByTimeComparator();

        Ticket [] actual =  manager.search(from, to, service);
        Ticket [] expected =  { ticket6, ticket1 };
        Assertions.assertArrayEquals(expected, actual);
    }
}