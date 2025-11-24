**Bank Account Simulation**

Create a BankAccount class with:

    fields: accountNumber, balance

    synchronized methods: deposit(), withdraw()

Write a program where multiple threads (e.g., 10 users) perform simultaneous deposits and withdrawals.

Ensure:

    no race conditions

    final balance is correct

    print thread-safe logs

Bonus: Solve using ReentrantLock instead of synchronized.