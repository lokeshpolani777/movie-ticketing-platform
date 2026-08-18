package com.movieticket.booking.repository;

import com.movieticket.booking.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Booking> getAllBookings() {

        String sql =
                "SELECT id, customer_name, movie_id, number_of_tickets " +
                "FROM bookings";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Booking(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getInt("movie_id"),
                        rs.getInt("number_of_tickets")
                )
        );
    }

    public Booking getBookingById(int id) {

        String sql =
                "SELECT id, customer_name, movie_id, number_of_tickets " +
                "FROM bookings WHERE id = ?";

        List<Booking> bookings = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Booking(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getInt("movie_id"),
                        rs.getInt("number_of_tickets")
                ),
                id
        );

        if (bookings.isEmpty()) {
            return null;
        }

        return bookings.get(0);
    }

    public Booking createBooking(Booking booking) {

        String sql =
                "INSERT INTO bookings " +
                "(id, customer_name, movie_id, number_of_tickets) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                booking.getId(),
                booking.getCustomerName(),
                booking.getMovieId(),
                booking.getNumberOfTickets()
        );

        return booking;
    }
}
