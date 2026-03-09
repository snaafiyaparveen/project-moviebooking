import "./navbar.css";
import { Link } from "react-router-dom";
import "./navbar.css";

export default function Navbar() {

  return (
    <div className="navbar">
      <div>🎬 MovieBook</div>

      <div>
        <Link to="/">Home</Link>
        <Link to="/login">Login</Link>
      </div>
    </div>
  );
}
