package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Map;

class TransportationNetwork {
    private List<City> cities = new ArrayList<>(); // List to store the cities
    private Map<String, Integer> cityIndices = new HashMap<>(); // Map to quickly access city index by name

    // Method to add a city to the network
    public void addCity(String name) {
        cities.add(new City(name)); // Add the city to the list
        cityIndices.put(name, cities.size() - 1); // Map the city name to its index
    }

    // Method to add a connection (edge) between two cities with the cost
    public void addConnection(int fromIndex, int toIndex, int cost) {
        cities.get(fromIndex).neighbors.put(toIndex, cost); // Add the connection to the from city's neighbors
    }

    // Method to find the minimum cost between two cities using Dijkstra's algorithm
    public int findMinCost(String source, String destination) {
        int sourceIdx = cityIndices.get(source); // Get the source city index
        int destIdx = cityIndices.get(destination); // Get the destination city index

        int[] distances = new int[cities.size()]; // Array to hold the minimum distances from source to all cities
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize all distances to infinity
        distances[sourceIdx] = 0; // The distance to the source city is 0

        // Priority queue to select the city with the smallest known distance at each step
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Min-heap based on distance
        pq.offer(new int[]{sourceIdx, 0}); // Start with the source city and a distance of 0

        // Dijkstra's algorithm loop
        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get the city with the smallest distance
            int cityIdx = current[0]; // The index of the city
            int dist = current[1]; // The current distance to this city

            // If we've reached the destination, return the distance
            if (cityIdx == destIdx) {
                return dist;
            }

            // If the current distance is greater than the already found shortest distance, skip it
            if (dist > distances[cityIdx]) continue;

            // Explore all neighbors of the current city
            for (Map.Entry<Integer, Integer> neighbor : cities.get(cityIdx).neighbors.entrySet()) {
                int newDist = dist + neighbor.getValue(); // Calculate the new distance to the neighbor
                if (newDist < distances[neighbor.getKey()]) { // If we found a shorter path to the neighbor
                    distances[neighbor.getKey()] = newDist; // Update the shortest distance
                    pq.offer(new int[]{neighbor.getKey(), newDist}); // Add the neighbor to the queue for further exploration
                }
            }
        }

        return -1; // Return -1 if no path exists between the source and destination
    }

    // Inner City class to represent each city
    static class City {
        String name; // Name of the city
        Map<Integer, Integer> neighbors = new HashMap<>(); // Map to store neighbors (cityIndex, cost)

        // Constructor to initialize the city with its name
        public City(String name) {
            this.name = name;
        }
    }
}