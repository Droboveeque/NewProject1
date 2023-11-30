import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldSortTicketsByPrice() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("СПб", "Вдк", 200, 9, 5);
        Ticket ticket2 = new Ticket("Вдк", "Хбр", 20, 7, 9);
        Ticket ticket3 = new Ticket("СПб", "Вдк", 60, 9, 11);
        Ticket ticket4 = new Ticket("Екб", "Мск", 100, 5, 10);
        Ticket ticket5 = new Ticket("СПб", "Екб", 40, 9, 12);
        Ticket ticket6 = new Ticket("СПб", "Вдк", 300, 14, 10);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("СПб", "Вдк");
        Ticket[] expected = {ticket3, ticket1, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByPriceWhenResultIsZero() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("СПб", "Вдк", 200, 9, 20);
        Ticket ticket2 = new Ticket("Вдк", "Хбр", 20, 7, 9);
        Ticket ticket3 = new Ticket("СПб", "Вдк", 60, 9, 11);
        Ticket ticket4 = new Ticket("Екб", "Мск", 100, 5, 10);
        Ticket ticket5 = new Ticket("СПб", "Екб", 40, 9, 12);
        Ticket ticket6 = new Ticket("СПб", "Вдк", 300, 14, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("СПб", "Хбр");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByPriceResultIsOneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("СПб", "Вдк", 200, 9, 5);
        Ticket ticket2 = new Ticket("Вдк", "Хбр", 20, 7, 9);
        Ticket ticket3 = new Ticket("СПб", "Вдк", 60, 9, 11);
        Ticket ticket4 = new Ticket("Екб", "Мск", 100, 5, 10);
        Ticket ticket5 = new Ticket("СПб", "Екб", 40, 9, 12);
        Ticket ticket6 = new Ticket("СПб", "Вдк", 300, 14, 10);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Вдк", "Хбр");
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByTime() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("СПб", "Вдк", 200, 9, 10);
        Ticket ticket2 = new Ticket("Вдк", "Хбр", 20, 7, 9);
        Ticket ticket3 = new Ticket("СПб", "Вдк", 60, 9, 19);
        Ticket ticket4 = new Ticket("Екб", "Мск", 100, 5, 10);
        Ticket ticket5 = new Ticket("СПб", "Екб", 40, 9, 12);
        Ticket ticket6 = new Ticket("СПб", "Вдк", 300, 14, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("СПб", "Вдк", comparator);
        Ticket[] expected = {ticket1, ticket6, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByTimeWhenResultIsZero() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("СПб", "Вдк", 200, 9, 10);
        Ticket ticket2 = new Ticket("Вдк", "Хбр", 20, 7, 9);
        Ticket ticket3 = new Ticket("СПб", "Вдк", 60, 9, 19);
        Ticket ticket4 = new Ticket("Екб", "Мск", 100, 5, 10);
        Ticket ticket5 = new Ticket("СПб", "Екб", 40, 9, 12);
        Ticket ticket6 = new Ticket("СПб", "Вдк", 300, 14, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("СПб", "Хбр", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByTimeWhenResultIsOneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("СПб", "Вдк", 200, 9, 10);
        Ticket ticket2 = new Ticket("Вдк", "Хбр", 20, 7, 9);
        Ticket ticket3 = new Ticket("СПб", "Вдк", 60, 9, 19);
        Ticket ticket4 = new Ticket("Екб", "Мск", 100, 5, 10);
        Ticket ticket5 = new Ticket("СПб", "Екб", 40, 9, 12);
        Ticket ticket6 = new Ticket("СПб", "Вдк", 300, 14, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Вдк", "Хбр", comparator);
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
