import "./movieCard.css";
import { Link } from "react-router-dom";
import "./movieCard.css";

export default function MovieCard({ movie }) {

  return (
    <div className="movie-card">
      <img src={movie.posterUrl} alt={movie.title} />
      <h3>{movie.title}</h3>

      <Link to={`/shows/${movie.id}`}>
        <button>Book</button>
      </Link>
    </div>
  );
}
