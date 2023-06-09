// Copyright (C) 2020
// All rights reserved
import java.util.Scanner;
/**
 * the summary for this project is a script maybe to resolve
 * the workshop problem
 * Esta es una clase de ejemplo que representa un objeto CostEstimator.
 * Permite calcular el costo de un viaje basado en diferentes factores.
 * @author H3nry
 */
public final class CostEstimator {
/**.
* valor final
*/
    private static final float BASE_COST = 1000;
    /**.
    * valor final
    */
    private static final float CITY_COST_PARIS = 500;
    /**.
     * valor final
     */
    private static final float CITY_COST_NYC = 600;
    /**.
     * valor final
     */
    private static final float PASSENGER_DISCOUNT = 0.1f;
    /**.
     * valor final
     */
    private static final float PASSENGER_SURCHARGE = 0.2f;
    /**.
     * valor final
     */
    private static final float DURATION_COST = 200;
    /**.
     * valor final
     */
    private static final int MIN_PASSENGERS = 1;
    /**.
     * valor final
     */
    private static final int MAX_PASSENGERS = 80;
    /**.
     * valor final
     */
    private static final int MIN_DURATION = 1;
    /**.
     * valor final
     */
    private static final int MAX_POPULAR_DURATION = 30;
    /**.
     * valor final
     */
    private static final int POPULAR_TRAVELERS = 2;
    /**.
     * constructor para que no lanze error
     */
    private CostEstimator() {
    }
    /**
     * Calcula el costo total del viaje.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main (final String[] args) {
        Scanner scan = new Scanner(System.in);
        float totalCost = BASE_COST;

        System.out.println("Costo base: " + BASE_COST);
        System.out.println("¿Ciudad popular? (SI/NO): ");
        String popularCity = scan.next();

        if ("SI".equals(popularCity)) {
            System.out.println("Ingrese "
+ "la ciudad de destino (Paris/New York City): ");
            String city = scan.next();

            while (!("Paris".equals(city) || "New York City".equals(city))) {
                System.out.println("Ingrese una ciudad "
+ "correcta (Paris/New York City): ");
                city = scan.next();
            }

            if ("Paris".equals(city)) {
                totalCost += CITY_COST_PARIS;
            } else {
                totalCost += CITY_COST_NYC;
            }
        }

        System.out.println("Costo: " + totalCost);

        System.out.println("Ingrese la cantidad de pasajeros:");
        int travelers = scan.nextInt();

        while (travelers < MIN_PASSENGERS || travelers > MAX_PASSENGERS) {
            System.out.println("Ingrese una cantidad de pasajeros correcta: ");
            travelers = scan.nextInt();
        }

        if (travelers > MIN_PASSENGERS && travelers < POPULAR_TRAVELERS) {
            totalCost += totalCost * PASSENGER_DISCOUNT;
        } else {
            totalCost += totalCost * PASSENGER_SURCHARGE;
        }

        System.out.println("Costo: " + totalCost);

        System.out.println("Ingrese la duracion del viaje(dias): ");
        int duration = scan.nextInt();

        while (duration < MIN_DURATION) {
            System.out.println("Ingrese una duracion valida(dias): ");
            duration = scan.nextInt();
        }

        if (duration < MAX_POPULAR_DURATION) {
            totalCost += DURATION_COST;
        }

        if (duration > MAX_POPULAR_DURATION && travelers == POPULAR_TRAVELERS) {
            totalCost -= DURATION_COST;
        }

        System.out.println("Costo Total: " + totalCost);
        scan.close();
    }
}
