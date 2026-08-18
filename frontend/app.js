const MOVIE_SERVICE_URL = "http://13.235.48.146:8081";
const BOOKING_SERVICE_URL = "http://13.235.48.146:8082";


// Load movies when page opens

async function loadMovies() {

    try {

        const response = await fetch(
            `${MOVIE_SERVICE_URL}/movies`
        );

        const movies = await response.json();

        const movieList =
            document.getElementById("movie-list");

        movieList.innerHTML = "";


        movies.forEach(movie => {

            const movieCard =
                document.createElement("div");

            movieCard.className = "movie-card";

            movieCard.innerHTML = `
                <h3>${movie.name}</h3>

                <p>
                    Movie ID: ${movie.id}
                </p>

                <p>
                    Language: ${movie.language}
                </p>

                <p>
                    Genre: ${movie.genre}
                </p>

                <button onclick="selectMovie(${movie.id})">
                    Book Ticket
                </button>
            `;

            movieList.appendChild(movieCard);
        });

    } catch (error) {

        console.error(error);

        document.getElementById("movie-list").innerHTML =
            "Unable to load movies.";
    }
}


// Select movie

function selectMovie(movieId) {

    document.getElementById("movieId").value =
        movieId;

    document.getElementById("customerName").focus();
}


// Create booking

document
    .getElementById("booking-form")
    .addEventListener("submit", async function(event) {

        event.preventDefault();


        const customerName =
            document.getElementById("customerName").value;

        const movieId =
            document.getElementById("movieId").value;

        const numberOfTickets =
            document.getElementById("numberOfTickets").value;


        const booking = {

            id: Date.now(),

            customerName: customerName,

            movieId: Number(movieId),

            numberOfTickets: Number(numberOfTickets)
        };


        try {

            const response = await fetch(
                `${BOOKING_SERVICE_URL}/bookings`,
                {
                    method: "POST",

                    headers: {
                        "Content-Type": "application/json"
                    },

                    body: JSON.stringify(booking)
                }
            );


            const result =
                await response.json();


            document.getElementById(
                "booking-result"
            ).innerHTML = `

                <h3>Booking Successful</h3>

                <p>
                    Booking ID: ${result.id}
                </p>

                <p>
                    Customer: ${result.customerName}
                </p>

                <p>
                    Movie ID: ${result.movieId}
                </p>

                <p>
                    Tickets: ${result.numberOfTickets}
                </p>
            `;


            document
                .getElementById("booking-form")
                .reset();

        } catch (error) {

            console.error(error);

            document.getElementById(
                "booking-result"
            ).innerHTML =
                "Booking failed.";
        }

    });


// Load movies

loadMovies();
