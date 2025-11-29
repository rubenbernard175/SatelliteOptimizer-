# SatelliteOptimizer-
Java implementation that simulates satellite data transmission limits by selecting the most valuable packets first. Uses a greedy value-density strategy, supports partial transfers, and returns a two-decimal optimized scientific value.
<h1 align="center">🛰 Satellite Data Transmission Optimizer</h1>
<p align="center">
Maximizing scientific data value using a greedy algorithm | COP3503C
</p>

---

### 🔰 Overview  
This program simulates data transmission from a research satellite with limited bandwidth.  
Each packet has a **size (MB)** and **scientific value**, and the satellite may transmit  
**full packets or fractional pieces of packets** — receiving proportional research value.  

A greedy strategy is used to maximize total scientific return:  
**transfer highest value-per-MB packets first.**

---

### 🔥 Features
| Capability | Description |
|---|---|
| 📡 Fractional packet transmission | Can send partial data to still gain value |
| ⚙️ Greedy optimization | Sorts by scientific value density |
| 🚀 High efficiency | Runs in **O(n log n)** due to sorting |
| 🔢 Accurate output | Final value rounded to **two decimals** |
| 📁 Supports any input size | Works for small & large missions |

---

### 📦 How It Works
1. Convert each data packet → `(size, value, ratio = value/size)`
2. Sort all packets from **highest to lowest ratio**
3. Transmit full packets until bandwidth is nearly full
4. If space remains → transmit **fraction of next packet**
5. Return total scientific value (rounded)

---

### 🧮 Example
Input:
