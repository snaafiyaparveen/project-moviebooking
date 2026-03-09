export const groupSeatsByRow = seats=>{
  const map={};
  seats.forEach(s=>{
    if(!map[s.rowLabel]) map[s.rowLabel]=[];
    map[s.rowLabel].push(s);
  });
  return Object.values(map);
};
