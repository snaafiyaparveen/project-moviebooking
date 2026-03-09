import React, { useState } from "react";

function SeatSelection() {

  const seats = Array.from({ length: 40 }, (_, i) => i + 1);
  const [selected, setSelected] = useState([]);

  const toggleSeat = (seat) => {
    if (selected.includes(seat))
      setSelected(selected.filter(s => s !== seat));
    else
      setSelected([...selected, seat]);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Select Seats</h2>

      <div style={{
        display: "grid",
        gridTemplateColumns: "repeat(8, 50px)",
        gap: "10px"
      }}>
        {seats.map(seat => (
          <div
            key={seat}
            onClick={() => toggleSeat(seat)}
            style={{
              height: "50px",
              background: selected.includes(seat) ? "green" : "gray",
              color: "white",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              cursor: "pointer"
            }}
          >
            {seat}
          </div>
        ))}
      </div>

      <h3>Selected Seats: {selected.join(", ")}</h3>

      <button style={{ marginTop: "20px" }}>
        Confirm Booking
      </button>
    </div>
  );
}

export default SeatSelection;
