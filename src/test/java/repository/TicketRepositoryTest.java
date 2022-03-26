package repository;

import domain.Ticket;
import manager.TicketManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Ticket first = new Ticket(1, 3000, "PEE", "SVO", 120);
    Ticket second = new Ticket(2, 2000, "LED", "VKO", 80);
    Ticket third = new Ticket(3, 10000, "SAW", "PEE", 320);
    Ticket fourth = new Ticket(4, 20000, "SVX", "SAW", 300);

    @Test
    void shouldSaveSomeTickets() {
        repository.save(first);
        repository.save(fourth);
        Ticket[] expected = new Ticket[]{first, fourth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSaveOneTicket() {

        repository.save(second);
        Ticket[] expected = new Ticket[]{second};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSaveAllTickets() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        Ticket[] expected = new Ticket[]{first, second, third, fourth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.removeById(3);

        Ticket[] expected = new Ticket[]{first, second, fourth};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdOneTicket() {

        repository.save(first);
        repository.removeById(1);

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}