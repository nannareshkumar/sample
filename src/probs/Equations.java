package probs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by home on 11/10/2020.
 */
public class Equations {

        public static Map<String, Integer> variables = new HashMap<String, Integer>();
        public static int fountValues = 0;

        public static void initVariables (ArrayList<String> eq) {
            for (String line: eq) {

                String[] tempSplit = line.split("=");
                String LHS = tempSplit[0].trim();
                String RHS = tempSplit[1].trim();

                String[] subStringLHS = LHS.split("\\+");
                String[] subStringRHS = RHS.split("\\+");

                for (String c : subStringLHS) {
                    c = c.trim();
                    if ((Character.isLetter(c.charAt(0)) == true)) {
                        variables.put(c, Integer.MIN_VALUE);
                    }
                }
                for (String c : subStringRHS) {
                    c = c.trim();
                    if ((Character.isLetter(c.charAt(0)) == true)) {
                        variables.put(c, Integer.MIN_VALUE);
                    }
                }
            }
        }

        public static int countChars(String line) {
            String[] elements = line.split(" ");
            int count = 0;

            for (String element : elements) {
                element = element.trim();

                if (Character.isLetter(element.charAt(0))) {
                    if(variables.get(element) == Integer.MIN_VALUE) {
                        count++;
                    }
                }
            }
            return count;
        }

        public static void loopPart(String line) {
            int charCount = countChars(line);

            if(charCount == 1) {
                solve(line);
            }
        }

        public static void solve (String line) {
            String[] elements = line.replace("+", "").split(" ");
            int LHValue = 0;
            int RHValue = 0;
            String variable = null;
            boolean isVariableLeft = true;
            boolean isRHS = false;

            for(String element : elements) {
                element = element.trim();
                if (!element.isEmpty()) {

                    if (!isRHS) {
                        if (!element.equals("=")) {
                            if (!Character.isLetter(element.charAt(0))) {
                                LHValue += Integer.parseInt(element);
                            } else {
                                if (variables.get(element) != Integer.MIN_VALUE) {
                                    LHValue += variables.get(element);
                                } else {
                                    isVariableLeft = true;
                                    variable = element;
                                }
                            }
                        } else {
                            isRHS = true;
                        }
                    } else {
                        if (!Character.isLetter(element.charAt(0))) {
                            RHValue += Integer.parseInt(element);
                        } else {
                            if (variables.get(element) != Integer.MIN_VALUE) {
                                RHValue += variables.get(element);
                            } else {
                                isVariableLeft = false;
                                variable = element;
                            }
                        }
                    }
                }
            }
            if (isVariableLeft) {
                variables.put(variable, (RHValue - LHValue));
            } else {
                variables.put(variable, (LHValue - RHValue));
            }
        }

        public static void main(String[] args) {
            ArrayList<String> eq = new ArrayList<>();
            eq.add("y = x + 1");
            eq.add("5 = x + 3");
            eq.add("10 = z + y + 2");
            eq.add("a = b + 1");
            eq.add("5 = b + 3");
            eq.add("10 = d + z + y + a + b");

            initVariables(eq);
            int end = variables.size();

// O(numberOfLines*numberOfVariables)
            for(int i = 0; i < end; i++) {
                for (String arr : eq) {
                    loopPart(arr);
                }
            }

            boolean isSolved = true;

            for (String key : variables.keySet()) {
                if(variables.get(key) == Integer.MIN_VALUE) {
                    System.out.println("Cannot be solved");
                    isSolved = false;
                    break;
                }
            }
            if(isSolved) {
                for (String key : variables.keySet()) {
                    System.out.println(key + ": " + variables.get(key));
                }
            }
        }
    }
