ordering of the threads, 
multiple threads -> sequence them in an order.

Java provides three methods : 

1- wait() -> When applied on an object, current thread waits for that object. Only possible when you have a
    lock on the object. When the thread goes to wait it will release the same lock that it was owning.

2- notify() -> (Almost never used) Notify on the same object for which you are waiting, asked to come out of waiting stage
    and start running.

3- notifyAll() -> (This is used 99% of the times) Works for all the threads that are in waiting state


public void counter() {
    // s0
    synchronized() { 
        // s1 
        wait();
        // s2
    }
}

