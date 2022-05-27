import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;

public class Generator {


    /**
     *
     * first determine the octave the note is in
     * secondly determine the note
     * thirdly put +1 or -1 depend on if sharp or flat presents
     *
     * @param note
     * @return the midi integer value of the note
     *
     */



    public static int transferToInt(String note) {
        int noteInt = 0;
        int noteNum = Integer.parseInt(note.substring(note.length() - 1));

        //C3 is 60

        noteInt += (noteNum + 2) * 12;

        if (note.contains("C")) {
            noteInt += 0;
        } else if (note.contains("D")) {
            noteInt += 2;
        } else if (note.contains("E")) {
            noteInt += 4;
        } else if (note.contains("F")) {
            noteInt += 5;
        } else if (note.contains("G")) {
            noteInt += 7;
        } else if (note.contains("A")) {
            noteInt += 9;
        } else if (note.contains("B")) {
            noteInt += 11;
        }

        if (note.contains("#")) {
            noteInt += 1;
        } else if (note.contains("b")) {
            noteInt += -1;
        }

        return noteInt;
    }

    //todo determine the scale
    public static String transferToNote(int noteInt, String scale) {
        String note = null;

        //sharp is true, C is also in sharp
        boolean sharpOrFlat = true;

        int noteName = (int)noteInt % 12;
        int noteOctave = (int)(noteInt / 12) - 2;

        if (scale.equalsIgnoreCase("F") || scale.contains("b")) {
            sharpOrFlat = false;
        }

        if (sharpOrFlat) {
            switch (noteName) {
                case 0:
                    note = "C" + noteOctave;
                    break;
                case 1:
                    note = "C#" + noteOctave;
                    break;
                case 2:
                    note = "D" + noteOctave;
                    break;
                case 3:
                    note = "D#" + noteOctave;
                    break;
                case 4:
                    note = "E" + noteOctave;
                    break;
                case 5:
                    note = "F" + noteOctave;
                    break;
                case 6:
                    note = "F#" + noteOctave;
                    break;
                case 7:
                    note = "G" + noteOctave;
                    break;
                case 8:
                    note = "G#" + noteOctave;
                    break;
                case 9:
                    note = "A" + noteOctave;
                    break;
                case 10:
                    note = "A#" + noteOctave;
                    break;
                case 11:
                    note = "B" + noteOctave;
                    break;
                default:
                    note = "error";
                    break;
            }
        } else {
            switch (noteName) {
                case 0:
                    note = "C" + noteOctave;
                    break;
                case 1:
                    note = "Db" + noteOctave;
                    break;
                case 2:
                    note = "D" + noteOctave;
                    break;
                case 3:
                    note = "Eb" + noteOctave;
                    break;
                case 4:
                    note = "E" + noteOctave;
                    break;
                case 5:
                    note = "F" + noteOctave;
                    break;
                case 6:
                    note = "Gb" + noteOctave;
                    break;
                case 7:
                    note = "G" + noteOctave;
                    break;
                case 8:
                    note = "Ab" + noteOctave;
                    break;
                case 9:
                    note = "A" + noteOctave;
                    break;
                case 10:
                    note = "Bb" + noteOctave;
                    break;
                case 11:
                    note = "B" + noteOctave;
                    break;
                default:
                    note = "error";
                    break;
            }
        }

        return note;
    }

    /**
     *
     * first note and last note should be an octave
     *
     * @param inputProcessed
     * @return

    public int[] firstAndLastProcess(int[] inputProcessed) {
        inputProcessed[0] += 12;

        inputProcessed[5] += 12;
        return inputProcessed;

    }
     */

    /**
     * use the first note to determine the key of the input melody, then determine the available notes in the scale
     *
     * can only handle major scales
     *
     *
     * @param inputProcessed
     * @return
     */


    /**public static int[] availableNotes(int[] inputProcessed) {
        int[] availableNotes = new int[7];
        int tonic = (int) inputProcessed[0] % 12;

        availableNotes[0] = tonic;
        availableNotes[1] = tonic + 2;
        availableNotes[2] = tonic + 4;
        availableNotes[3] = tonic + 5;
        availableNotes[4] = tonic + 7;
        availableNotes[5] = tonic + 9;
        availableNotes[6] = tonic + 11;

        for (int i = 0; i < 7; i++) {
            if (availableNotes[i] >= 12) {
                availableNotes[i] -= 12;

                System.out.println("i: " + availableNotes[i]);
            }
        }

        return availableNotes;
    }
     */



    public static void main(String[] args) {
        List list1;
        List[] listArray;
        ArrayList<List> listArrayListChecked;

        Scanner scanner = new Scanner(System.in);

        listArray = new List[59049];


        //todo input

        String[] inputArray = new String[8];

        System.out.println("Please use # or b to indicate sharps or flats!");

        System.out.println("Please enter the melody with comma between each note: ");
        String inputString = scanner.nextLine();
        scanner.close();

        inputArray = inputString.split(",");

        int[] inputProcessed = new int[8];

        try {

            for (int p = 0; p < 8; p++) {
                inputProcessed[p] = transferToInt(inputArray[p]);

            }
        } catch (Exception e) {
            System.out.println("Please check the melody you entered!");
        }


        /**int[] inputProcessed = new int[8];
        inputProcessed[0] = 60;
        inputProcessed[1] = 62;
        inputProcessed[2] = 64;
        inputProcessed[3] = 67;
        inputProcessed[4] = 65;
        inputProcessed[5] = 64;
        inputProcessed[6] = 62;
        inputProcessed[7] = 60;

         C3,D3,E3,G3,F3,E3,D3,C3
         */

        int[] availableNotes;
        availableNotes = new int[7];
        int tonic;
        tonic = (int) inputProcessed[0] % 12;

        availableNotes[0] = tonic;
        availableNotes[1] = tonic + 2;
        availableNotes[2] = tonic + 4;
        availableNotes[3] = tonic + 5;
        availableNotes[4] = tonic + 7;
        availableNotes[5] = tonic + 9;
        availableNotes[6] = tonic + 11;

        for (int x = 0; x < 7; x++) {
            if (availableNotes[x] >= 12) {
                availableNotes[x] -= 12;

            }
        }

        int a;
        int b;
        int c;
        int d;
        int e;

        int f = inputProcessed[6] - inputProcessed[0];
        int seventh;
        if (f == 0 || f == 2 || f == 5 || f == 7) {
            seventh = inputProcessed[6] + 9;
        } else {
            seventh = inputProcessed[6] + 8;
        }


        //todo add 10th
        for (a = 0; a < 9; a++) {
            for (b = 0; b < 9; b++) {
                for (c = 0; c < 9; c++) {
                    for (d = 0; d < 9; d++) {
                        for (e = 0; e < 9; e++) {
                            int[] listToAdd;
                            listToAdd = new int[8];

                            listToAdd[0] = inputProcessed[0] + 12;

                            listToAdd[6] = seventh;
                            listToAdd[7] = inputProcessed[7] + 12;



                            switch (a) {
                                //Unison
                                case 0:
                                    listToAdd[1] = inputProcessed[1];
                                    break;
                                //minor 3rd
                                case 1:
                                    listToAdd[1] = inputProcessed[1] + 3;
                                    break;
                                //major 3rd
                                case 2:
                                    listToAdd[1] = inputProcessed[1] + 4;
                                    break;
                                //5th
                                case 3:
                                    listToAdd[1] = inputProcessed[1] + 7;
                                    break;
                                //minor 6th
                                case 4:
                                    listToAdd[1] = inputProcessed[1] + 8;
                                    break;
                                //major 6th
                                case 5:
                                    listToAdd[1] = inputProcessed[1] + 9;
                                    break;
                                //Octave
                                case 6:
                                    listToAdd[1] = inputProcessed[1] + 12;
                                    break;
                                //minor 10th
                                case 7:
                                    listToAdd[1] = inputProcessed[1] + 15;
                                    break;
                                //major 10th
                                case 8:
                                    listToAdd[1] = inputProcessed[1] + 16;
                                    break;

                            }

                            switch (b) {
                                //Unison
                                case 0:
                                    listToAdd[2] = inputProcessed[2];
                                    break;
                                //minor 3rd
                                case 1:
                                    listToAdd[2] = inputProcessed[2] + 3;
                                    break;
                                //major 3rd
                                case 2:
                                    listToAdd[2] = inputProcessed[2] + 4;
                                    break;
                                //5th
                                case 3:
                                    listToAdd[2] = inputProcessed[2] + 7;
                                    break;
                                //minor 6th
                                case 4:
                                    listToAdd[2] = inputProcessed[2] + 8;
                                    break;
                                //major 6th
                                case 5:
                                    listToAdd[2] = inputProcessed[2] + 9;
                                    break;
                                //Octave
                                case 6:
                                    listToAdd[2] = inputProcessed[2] + 12;
                                    break;
                                //minor 10th
                                case 7:
                                    listToAdd[2] = inputProcessed[2] + 15;
                                    break;
                                //major 10th
                                case 8:
                                    listToAdd[2] = inputProcessed[2] + 16;
                                    break;

                            }

                            switch (c) {
                                //Unison
                                case 0:
                                    listToAdd[3] = inputProcessed[3];
                                    break;
                                //minor 3rd
                                case 1:
                                    listToAdd[3] = inputProcessed[3] + 3;
                                    break;
                                //major 3rd
                                case 2:
                                    listToAdd[3] = inputProcessed[3] + 4;
                                    break;
                                //5th
                                case 3:
                                    listToAdd[3] = inputProcessed[3] + 7;
                                    break;
                                //minor 6th
                                case 4:
                                    listToAdd[3] = inputProcessed[3] + 8;
                                    break;
                                //major 6th
                                case 5:
                                    listToAdd[3] = inputProcessed[3] + 9;
                                    break;
                                //Octave
                                case 6:
                                    listToAdd[3] = inputProcessed[3] + 12;
                                    break;
                                //minor 10th
                                case 7:
                                    listToAdd[3] = inputProcessed[3] + 15;
                                    break;
                                //major 10th
                                case 8:
                                    listToAdd[3] = inputProcessed[3] + 16;
                                    break;

                            }

                            switch (d) {
                                //Unison
                                case 0:
                                    listToAdd[4] = inputProcessed[4];
                                    break;
                                //minor 3rd
                                case 1:
                                    listToAdd[4] = inputProcessed[4] + 3;
                                    break;
                                //major 3rd
                                case 2:
                                    listToAdd[4] = inputProcessed[4] + 4;
                                    break;
                                //5th
                                case 3:
                                    listToAdd[4] = inputProcessed[4] + 7;
                                    break;
                                //minor 6th
                                case 4:
                                    listToAdd[4] = inputProcessed[4] + 8;
                                    break;
                                //major 6th
                                case 5:
                                    listToAdd[4] = inputProcessed[4] + 9;
                                    break;
                                //Octave
                                case 6:
                                    listToAdd[4] = inputProcessed[4] + 12;
                                    break;
                                //minor 10th
                                case 7:
                                    listToAdd[4] = inputProcessed[4] + 15;
                                    break;
                                //major 10th
                                case 8:
                                    listToAdd[4] = inputProcessed[4] + 16;
                                    break;

                            }

                            switch (e) {
                                //Unison
                                case 0:
                                    listToAdd[5] = inputProcessed[5];
                                    break;
                                //minor 3rd
                                case 1:
                                    listToAdd[5] = inputProcessed[5] + 3;
                                    break;
                                //major 3rd
                                case 2:
                                    listToAdd[5] = inputProcessed[5] + 4;
                                    break;
                                //5th
                                case 3:
                                    listToAdd[5] = inputProcessed[5] + 7;
                                    break;
                                //minor 6th
                                case 4:
                                    listToAdd[5] = inputProcessed[5] + 8;
                                    break;
                                //major 6th
                                case 5:
                                    listToAdd[5] = inputProcessed[5] + 9;
                                    break;
                                //Octave
                                case 6:
                                    listToAdd[5] = inputProcessed[5] + 12;
                                    break;
                                //minor 10th
                                case 7:
                                    listToAdd[5] = inputProcessed[5] + 15;
                                    break;
                                //major 10th
                                case 8:
                                    listToAdd[5] = inputProcessed[5] + 16;
                                    break;

                            }


                            list1 = new List(listToAdd, true);


                            int positionInArray = a * 9 * 9 * 9 * 9 + b * 9 * 9 * 9 + c * 9 * 9 + d * 9 + e;

                            listArray[positionInArray] = list1;
                        }


                    }
                }
            }
        }


        for (int i = 0; i < 59049; i++) {
            List listObjToCheck = listArray[i];
            int[] listToCheck = listObjToCheck.getList();

            int highestNote = listToCheck[0];


            //check individual notes
            for (int j = 0; j < 8; j++) {
                //Check for notes not in the scale

                int noteToCheck = listToCheck[j];
                int checkInt = 0;

                for (int k = 0; k < 7; k++) {
                    if (availableNotes[k] != noteToCheck % 12) {
                        checkInt++;
                    }
                }

                if (checkInt == 7) {
                    listArray[i].setCheck(false);
                }

                //Check if the highest note only appears once

                if (highestNote < listToCheck[j]) {
                    highestNote = listToCheck[j];
                }


            }

            int highestNoteCount = 0;

            for (int j1 = 0; j1 < 8; j1++) {
                if (listToCheck[j1] == highestNote) {
                    highestNoteCount++;
                }

            }

            if (highestNoteCount != 1) {
                listArray[i].setCheck(false);
            }




            //check for two notes
            for (int k = 0; k < 7; k++) {
                //Check for parallel fifths
                if ((listToCheck[k] - inputProcessed[k]) % 12 == 7) {
                    if ((listToCheck[k + 1] - inputProcessed[k + 1]) % 12 == 7) {
                        listArray[i].setCheck(false);
                    }
                }

                //Check for parallel eighth
                if ((listToCheck[k] - inputProcessed[k]) % 12 == 0) {
                    if ((listToCheck[k + 1] - inputProcessed[k + 1]) % 12 == 0) {
                        listArray[i].setCheck(false);
                    }
                }
                //todo check for leaps
                //Check for leaps if they are 3rd, 4th, 5th, or 6th
                if (Math.abs((listToCheck[k] - listToCheck[k + 1])) != 0 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 1 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 2 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 3 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 4 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 5 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 7 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 8 &&
                        Math.abs((listToCheck[k] - listToCheck[k + 1])) != 9) {

                    listArray[i].setCheck(false);
                }

                for (int o = 0; o < 6; o++) {

                    if ((listToCheck[o] == listToCheck[o + 1]) || ((listToCheck[o + 1] == listToCheck[o + 2]))) {
                        listArray[i].setCheck(false);
                    }


                    if (Math.abs((listToCheck[o] - listToCheck[o + 1])) >= 4) {
                        if ((Math.abs((listToCheck[o + 1] - listToCheck[o + 2])) >= 4)) {
                            listArray[i].setCheck(false);
                        }
                    }

                }




                for (int o1 = 0; o1 < 4; o1++) {
                    if (Math.abs((listToCheck[o1] - listToCheck[o1 + 1])) >= 4) {
                        if ((Math.abs((listToCheck[o1 + 2] - listToCheck[o1 + 3])) >= 2)) {
                            listArray[i].setCheck(false);
                        }
                    }
                }



            }
        }

        System.out.println("\nResults: \n");

        int answerCount = 0;
        for (int w = 0; w < 59049; w++) {
            if (listArray[w].isCheck()) {
                answerCount++;

                System.out.println("No." + answerCount);

                for (int l = 0; l < 7; l++) {
                    System.out.print(transferToNote(listArray[w].getList()[l], inputArray[0]) + ",");
                }
                System.out.print(transferToNote(listArray[w].getList()[7], inputArray[0]));
                System.out.println();
                System.out.println(inputString + "\n");
            }


        }

        if (answerCount == 0) {
            System.out.println("No Melody Found! Please enter a new melody.");

        } else {
            System.out.println("Total counterpoint melody generated: " + answerCount);
        }


        //main method
    }

}
