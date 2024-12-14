package Firstcome;

public class Main {


    public static void main(String[] args) {
        // Initialize memory and process data
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};

        // Allocation array to store block index for each process
        int allocation[] = new int[processSize.length];
        for (int i = 0; i < processSize.length; i++) {
            allocation[i] = -1; // Start with no allocations
        }

        // First Fit Algorithm: Iterate through processes
        for (int i = 0; i < processSize.length; i++) {
            for (int j = 0; j < blockSize.length; j++) {
                if (blockSize[j] >= processSize[i]) { // Check if block fits
                    allocation[i] = j; // Allocate block
                    blockSize[j] -= processSize[i]; // Reduce available memory
                    break; // Move to next process
                }
            }
        }

        // Display allocation results
        System.out.println("Process No.\tProcess Size\tBlock no.");
        for (int i = 0; i < processSize.length; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1); // Display block ID
            else
                System.out.print("Not Allocated"); // Unallocated process
            System.out.println();
        }
    }
}