import React, { useEffect, useState } from "react";
import axios from "axios";

function Movies() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/movies")
      .then(res => setMovies(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Now Showing</h2>

      <div style={{ display: "flex", gap: "20px", flexWrap: "wrap" }}>
        {movies.map(movie => (
          <div key={movie.id} style={{
            width: "200px",
            border: "1px solid #ccc",
            padding: "10px",
            borderRadius: "10px"
          }}>
            <h3>{movie.title}</h3>
            <p>{movie.genre}</p>
            <button onClick={() => window.location.href=`/seats/${movie.id}`}>
              Book Seats
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Movies;
