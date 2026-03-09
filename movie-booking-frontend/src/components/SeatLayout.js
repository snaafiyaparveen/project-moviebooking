function SeatLayout({seats,onSelect}){

  return(
    <div>
      <div className="screen">SCREEN</div>
      {seats.map(s=>(
        <button
          key={s.id}
          className={s.status.toLowerCase()}
          onClick={()=>onSelect(s)}
        >
          {s.rowLabel}{s.seatNumber}
        </button>
      ))}
    </div>
  );
}
export default SeatLayout;
