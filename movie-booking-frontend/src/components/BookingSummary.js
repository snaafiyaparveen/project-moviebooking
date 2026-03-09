export default function BookingSummary({seats,total}){
  return(
    <div>
      <h3>Selected Seats</h3>
      {seats.map(s=>(
        <p key={s.id}>{s.rowLabel}{s.seatNumber}</p>
      ))}
      <h4>Total: ₹{total}</h4>
    </div>
  );
}
