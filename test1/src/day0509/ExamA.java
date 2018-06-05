package day0509;

public class ExamA {
	private static int arr[] = new int[5];
    public static void main(String args[]) {
        for(int i=arr.length-1;i>=0;i--)
            arr[i] = 2*i+1;
        String output = "0";
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            output += " + " + arr[i];
        }
        output += " = "+sum;
        System.out.println(output);
        System.exit(0);
    }

}
