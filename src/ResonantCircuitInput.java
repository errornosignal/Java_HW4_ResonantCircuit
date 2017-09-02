import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Set;

import static java.lang.System.exit;

/**
 * Class for getting user input values for ResonantCircuit class
 * @author Reid Nolan
 * @version 1.0
 * Created on 3/24/2017.
 */
public class ResonantCircuitInput
{
    /**
     * main method for ResonantCircuitInput class
     * @param args parFreq, parBand, parGain, serFreq, serBand, serGain
     */
    public static void main(String[] args)
    {
        //display program header
        displayProgramHeader();

        //loop until user opts to quit
        while (true)
        {
            //create new scanner
            Scanner sc = new Scanner(System.in);

            //create sets for circuit values
            Set<Double> ParallelResonantCircuit = new HashSet<>();
            Set<Double> SeriesResonantCircuit = new HashSet<>();

            //define and initialize class variables
            int mainSelection = 0;     //main menu switch parameter
            double parFreq = 0.0;      //parallel frequency
            double parBand = 0.0;      //parallel bandwidth
            double parGain = 0.0;      //parallel gain
            double serFreq = 0.0;      //series frequency
            double serBand = 0.0;      //series bandwidth
            double serGain = 0.0;      //series gain

            //display main menu
            displayMainMenu();

            //validates and gets main menu choice
            boolean mainGood = false;
            while (!mainGood)
            {
                //prompt user for input
                System.out.print("Enter your selection: ");
                try
                {
                    //set scanner input to upcoming switch variable
                    mainSelection = sc.nextInt();
                    //validate user input
                    if (mainSelection == 1 || mainSelection == 2 || mainSelection == 3)
                    {
                        //if valid input
                        mainGood = true;
                    }
                    else
                    {
                        //if invalid input
                        displayInvalidEntryError();
                    }
                }
                //exception handler
                catch (InputMismatchException IOE)
                {
                    //display invalid entry warning and clear input stream for invalid entry
                    displayInvalidEntryError();
                    sc.reset();
                    sc.next();
                }
            }

            //switch for main menu options
            switch (mainSelection)
            {
                //1. Run the automated test with predefined values
                case 1:
                    //set pre-defined values for parallel/series frequency. bandwidth, and gain
                    parFreq = 10.0;     //parallel frequency
                    parBand = 5.0;      //parallel bandwidth
                    parGain = 2.5;      //parallel gain
                    serFreq = 10.0;     //series frequency
                    serBand = 5.0;      //series bandwidth
                    serGain = 2.5;      //series gain
                    break;
                //2. Input my own values for both circuits
                case 2:
                    //loop for getting user input
                    for (int i = 0; i < 2; i++)
                    {
                        if (i == 0)
                        {
                            //prompt user for input
                            System.out.println("Input values for parallel resonant circuit.");
                            //loop to get parallel circuit input
                            for (int j = 0; j < 3; j++)
                            {
                                if (j == 0)
                                {
                                    //get parallel resonant circuit frequency
                                    boolean parFreqValid = false;
                                    while (!parFreqValid)
                                    {
                                        //prompt user for input
                                        frequencyPrompt();
                                        try
                                        {
                                            //set next scanner input to variable value
                                            parFreq = sc.nextDouble();

                                            //validate non-duplicate value
                                            if(ParallelResonantCircuit.contains(parFreq))
                                            {
                                                //display duplicate value entered message
                                                displayDuplicateError();
                                            }
                                            else
                                            {
                                                //add value to set
                                                ParallelResonantCircuit.add(parFreq);
                                                parFreqValid = true;
                                            }
                                        }
                                        //exception handler
                                        catch (InputMismatchException IOE)
                                        {
                                            //display invalid entry warning and clear input stream for non-double input
                                            displayInvalidDoubleError();
                                            sc.reset();
                                            sc.next();
                                        }
                                    }
                                } else if (j == 1)
                                {
                                    //get parallel resonant circuit bandwidth
                                    boolean parBandValid = false;
                                    while (!parBandValid)
                                    {
                                        //prompt user for input
                                        bandwidthPrompt();
                                        try
                                        {
                                            //set next scanner input to variable value
                                            parBand = sc.nextDouble();

                                            //validate non-duplicate value
                                            if(ParallelResonantCircuit.contains(parBand))
                                            {
                                                //display duplicate value entered message
                                                displayDuplicateError();
                                            }
                                            else
                                            {
                                                //add value to set
                                                ParallelResonantCircuit.add(parBand);
                                                parBandValid = true;
                                            }
                                        }
                                        //exception handler
                                        catch (InputMismatchException IOE)
                                        {
                                            //display invalid entry warning and clear input stream for non-double input
                                            displayInvalidDoubleError();
                                            sc.reset();
                                            sc.next();
                                        }
                                    }
                                } else if (j == 2)
                                {
                                    //get parallel resonant circuit gain
                                    boolean parGainValid = false;
                                    while (!parGainValid)
                                    {
                                        //prompt user for input
                                        gainPrompt();
                                        try
                                        {
                                            //set next scanner input to variable value
                                            parGain = sc.nextDouble();

                                            //validate non-duplicate value
                                            if(ParallelResonantCircuit.contains(parGain))
                                            {
                                                //display duplicate value entered message
                                                displayDuplicateError();
                                            }
                                            else
                                            {
                                                //add value to set
                                                ParallelResonantCircuit.add(parGain);
                                                parGainValid = true;
                                            }
                                        }
                                        //exception handler
                                        catch (InputMismatchException IOE)
                                        {
                                            //display invalid entry warning and clear input stream for non-double input
                                            displayInvalidDoubleError();
                                            sc.reset();
                                            sc.next();
                                        }
                                    }
                                } else
                                {
                                    //do nothing
                                }
                            }
                        } else if (i == 1)
                        {

                            System.out.println("Input values for series resonant circuit.");
                            //loop to get series circuit input
                            for (int j = 0; j < 3; j++)
                            {
                                if (j == 0)
                                {
                                    //get series resonant circuit frequency
                                    boolean serFreqValid = false;
                                    while (!serFreqValid)
                                    {
                                        //prompt user for input
                                        frequencyPrompt();
                                        try
                                        {
                                            //set next scanner input to variable value
                                            serFreq = sc.nextDouble();

                                            //validate non-duplicate value
                                            if (SeriesResonantCircuit.contains(serFreq))
                                            {
                                                //display duplicate value entered message
                                                displayDuplicateError();
                                            }
                                            else
                                            {
                                                //add value to set
                                                SeriesResonantCircuit.add(serFreq);
                                                serFreqValid = true;
                                            }
                                        }
                                        //exception handler
                                        catch (InputMismatchException IOE)
                                        {
                                            //display invalid entry warning and clear input stream for non-double input
                                            displayInvalidDoubleError();
                                            sc.reset();
                                            sc.next();
                                        }
                                    }
                                }
                                else if (j == 1)
                                {
                                    //get series resonant circuit bandwidth
                                    boolean serBandValid = false;
                                    while (!serBandValid)
                                    {
                                        //prompt user for input
                                        bandwidthPrompt();
                                        try
                                        {
                                            //set next scanner input to variable value
                                            serBand = sc.nextDouble();

                                            //validate non-duplicate value
                                            if(SeriesResonantCircuit.contains(serBand))
                                            {
                                                //display duplicate value entered message
                                                displayDuplicateError();
                                            }
                                            else
                                            {
                                                //add value to set
                                                SeriesResonantCircuit.add(serBand);
                                                serBandValid = true;
                                            }
                                        }
                                        //exception handler
                                        catch (InputMismatchException IOE)
                                        {
                                            //display invalid entry warning and clear input stream for non-double input
                                            displayInvalidDoubleError();
                                            sc.reset();
                                            sc.next();
                                        }
                                    }
                                }
                                else if (j == 2)
                                {
                                    //get series resonant circuit gain
                                    boolean serGainValid = false;
                                    while (!serGainValid)
                                    {
                                        //prompt user for input
                                        gainPrompt();
                                        try
                                        {
                                            //set next scanner input to variable value
                                            serGain = sc.nextDouble();

                                            //validate non-duplicate value
                                            if(SeriesResonantCircuit.contains(serGain))
                                            {
                                                //display duplicate value entered message
                                                displayDuplicateError();
                                            }
                                            else
                                            {
                                                //add value to set
                                                SeriesResonantCircuit.add(serGain);
                                                serGainValid = true;
                                            }
                                        }
                                        //exception handler
                                        catch (InputMismatchException IOE)
                                        {
                                            //display invalid entry warning and clear input stream for non-double input
                                            displayInvalidDoubleError();
                                            sc.reset();
                                            sc.next();
                                        }
                                    }
                                }
                                else
                                {
                                    //do nothing
                                }
                            }
                        }
                    }
                    break;
                //3. Exit the program
                case 3:
                    //display program termination message
                    System.out.println("exiting program...");
                    exit(1);
                    break;
                default:
                    //display invalid entry warning
                    displayInvalidEntryError();
                    break;
            }

            System.out.println();

            //create new ParallelResonantCircuit
            ResonantCircuit.ParallelResonantCircuit parallelCircuit = new ResonantCircuit.ParallelResonantCircuit();
            //method call to set values
            parallelCircuit.setValues(parFreq, parBand, parGain);
            //method call to display values
            final String parallelString = parallelCircuit.toString();
            System.out.println(parallelString);

            //create new SeriesResonantCircuit
            ResonantCircuit.SeriesResonantCircuit seriesCircuit = new ResonantCircuit.SeriesResonantCircuit();
            //method call to set values
            seriesCircuit.setValues(serFreq, serBand, serGain);
            //method call to display values
            final String seriesString = seriesCircuit.toString();
            System.out.println(seriesString);

            System.out.println();
        }
    }

    /**
     * displays program header
     */
    private static void displayProgramHeader()
    {
        System.out.println("Reid_Nolan_HW4_[Resonant_Circuit]");
        System.out.println("Java program for determining values of parallel and series resonant circuits." + "\n");
    }

    /**
     * displays main menu
     */
    private static void displayMainMenu()
    {
        System.out.println("-----Main Menu-----");
        System.out.println("1. Run the automated test with predefined values.");
        System.out.println("2. Input my own values for both circuits.");
        System.out.println("3. Exit the program.");
    }

    /**
     * displays frequency prompt
     */
    private static void frequencyPrompt()
    {
        System.out.print("Frequency: ");
    }

    /**
     * displays bandwidth prompt
     */
    private static void bandwidthPrompt()
    {
        System.out.print("Bandwidth: ");
    }

    /**
     * displays gain prompt
     */
    private static void gainPrompt()
    {
        System.out.print("Gain: ");
    }

    /**
     * displays invalid entry message
     */
    private static void displayInvalidEntryError()
    {
        System.out.println("Error! Invalid entry. Try again.");
    }

    /**
     * displays duplicate entry message
     */
    private static void displayDuplicateError()
    {
        System.out.println("Error! Duplicate values are not allowed");
    }

    /**
     * displays invalid double entry message
     */
    private static void displayInvalidDoubleError()
    {
        System.out.println("Error! Invalid double value. Try again.");
    }
}