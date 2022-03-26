package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Ticket first = new Ticket(1, 3000, "PEE", "SVO", 120);
    Ticket second = new Ticket(2, 2000, "LED", "VKO", 80);
    Ticket third = new Ticket(3, 10000, "SAW", "PEE", 320);
    Ticket fourth = new Ticket(4, 20000, "SVX", "SAW", 300);
    Ticket fiveth = new Ticket(5, 1500, "PEE", "SVO", 100);
    Ticket sixth = new Ticket(6,1200, "LED", "VKO", 70);


    @Test
    void shouldAddTickets() {
        manager.add(first);
        manager.add(second);
        manager.add(fourth);
        manager.add(third);
        manager.add(fiveth);

        Ticket[] expected = new Ticket[]{first, second, fourth, third, fiveth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortByPrice() {

        Ticket[] expected = new Ticket[]{fiveth, second, first, third, fourth};
        Ticket[] actual = new Ticket[]{fourth, third, first, second, fiveth};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchPEESVO() {
        manager.add(first);
        manager.add(second);
        manager.add(fourth);
        manager.add(third);
        manager.add(fiveth);

        Ticket[] expected = new Ticket[]{fiveth, first};
        Ticket[] actual = manager.findAll("PEE", "SVO");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSVOPEE() {
        manager.add(first);
        manager.add(second);
        manager.add(fourth);
        manager.add(third);
        manager.add(fiveth);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("SVO", "PEE");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchLEDVKO() {
        manager.add(first);
        manager.add(second);
        manager.add(fourth);
        manager.add(third);
        manager.add(fiveth);
        manager.add(sixth);

        Ticket [] expected = new Ticket[] {sixth, second};
        Ticket [] actual = manager.findAll("LED", "VKO");

        Arrays.sort(actual);

        assertArrayEquals(expected,actual);
    }
}