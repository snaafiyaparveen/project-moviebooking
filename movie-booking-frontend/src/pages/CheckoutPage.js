import BookingSummary from "../components/BookingSummary";

export default function CheckoutPage(){
  return(
    <div>
      <BookingSummary seats={[]} total={500}/>
      <button>Pay Now</button>
    </div>
  );
}
