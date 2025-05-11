package ConcurrentTicketBooking;

import java.util.Map;

public class TicketBooking {
    Map<Seat, Integer> seatToUserMap;
    Map<Seat, Integer> seatToUserHoldMap;
    public void bookSeat(Seat seat, Integer userId) throws Exception {
        synchronized (seat){
            Integer currentUser = seatToUserMap.get(seat);
            if(currentUser != null) {
                throw new Exception("Seat Already Booked");
            }
        }
        seatToUserMap.put(seat, userId);
    }

    synchronized public void holdSeat(Seat seat, Integer userId) throws Exception {
        synchronized(seat) {
            Integer currentHoldingUser = seatToUserHoldMap.get(seat);
            if (currentHoldingUser != null) {
                throw new Exception("Seat already held");
            }
            Integer currentBookedUser = seatToUserMap.get(seat);
            if (currentBookedUser != null) {
                throw new Exception("Seat already booked");
            }
            seatToUserHoldMap.put(seat, userId);
        }
    }
}
