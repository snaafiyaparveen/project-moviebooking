import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";

import HomePage from "./pages/HomePage";
import MovieDetailsPage from "./pages/MovieDetailsPage";
import TheaterShowsPage from "./pages/TheaterShowsPage";
import SeatSelectionPage from "./pages/SeatSelectionPage";
import CheckoutPage from "./pages/CheckoutPage";
import BookingHistoryPage from "./pages/BookingHistoryPage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";

import AdminDashboard from "./admin/AdminDashboard";

function App() {
  return (
    <BrowserRouter>

      <Navbar />

      <Routes>

        <Route path="/" element={<HomePage />} />

        <Route path="/movie/:id" element={<MovieDetailsPage />} />

        <Route path="/shows/:movieId" element={<TheaterShowsPage />} />

        <Route path="/seats/:showId" element={<SeatSelectionPage />} />

        <Route path="/checkout" element={<CheckoutPage />} />

        <Route path="/history" element={<BookingHistoryPage />} />

        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />

        <Route path="/admin" element={<AdminDashboard />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;
