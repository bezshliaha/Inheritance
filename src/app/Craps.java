package app;

class Craps {
    protected double bet;

    public Craps(double bet) {
        this.bet = bet;
    }

    public double calculateWin() {
        return 0;
    }
}

class WinLessThan3 extends Craps {
    public WinLessThan3(double bet) {
        super(bet);
    }

    public double calculateWin() {
        return bet * 1.25;
    }
}

class Win3to7 extends Craps {
    public Win3to7(double bet) {
        super(bet);
    }

    public double calculateWin() {
        return bet * 1.25 - (bet * 0.05);
    }
}

class WinMoreThan7 extends Craps {
    public WinMoreThan7(double bet) {
        super(bet);
    }

    public double calculateWin() {
        return (bet * 2) - (bet * 0.1);
    }
}