import { createContext, useState } from "react";

export const BookingContext = createContext();

export const BookingProvider = ({children}) => {
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [show, setShow] = useState(null);

  return (
    <BookingContext.Provider value={{selectedSeats,setSelectedSeats,show,setShow}}>
      {children}
    </BookingContext.Provider>
  );
};
