package ca.yorku.eecs.mcalc;

public class MortgageModel
{
    private double principle, amortization, interest;
    public MortgageModel (String p, String a, String i)
    {
    this.principle = Double.parseDouble(p);
    this.amortization = Double.parseDouble(a);
    this.interest = Double.parseDouble(i);
    }
    public String computePayment()
    {
            double p = this.principle;
            double n = (this.amortization)*12;
            double r = (this.interest)/1200;
            double index1 = (r*p);
            double index2 = (Math.pow(1+r,-n));
            double index0 = index1 / ( 1 - index2) ;
            String result = String.format("$%,.2f", index0);
            return result;
    }

    public static void main (String [] args) {
        MortgageModel myModel = new MortgageModel("700000", "25" , "2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.50");
        System.out.println(myModel.computePayment());

}

}
