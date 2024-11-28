import numpy as np
import matplotlib.pyplot as plt

def cubic_spline_interpolation(x_nodes, y_nodes, x_dense):
    n = len(x_nodes) - 1  # Число интервалов
    h = np.diff(x_nodes)  # Шаги между узлами

    # Формируем матрицу и правую часть для решения системы
    A = np.zeros((n + 1, n + 1))  # Матрица коэффициентов
    b = np.zeros(n + 1)           # Правая часть

    # Внутренние узлы: коэффициенты второй производной
    for i in range(1, n):
        A[i, i - 1] = h[i - 1]
        A[i, i] = 2 * (h[i - 1] + h[i])
        A[i, i + 1] = h[i]
        b[i] = 3 * ((y_nodes[i + 1] - y_nodes[i]) / h[i] - (y_nodes[i] - y_nodes[i - 1]) / h[i - 1])

    # Краевые условия: натуральный сплайн (вторая производная равна нулю)
    A[0, 0] = 1
    A[n, n] = 1

    # Решаем систему для нахождения второй производной (коэффициенты c_i)
    c = np.linalg.solve(A, b)

    # Находим коэффициенты b_i и d_i для полинома на каждом интервале
    b_coeffs = np.zeros(n)
    d_coeffs = np.zeros(n)
    a_coeffs = y_nodes[:-1]  # a_i - значения функции в узлах
    for i in range(n):
        b_coeffs[i] = (y_nodes[i + 1] - y_nodes[i]) / h[i] - h[i] * (2 * c[i] + c[i + 1]) / 3
        d_coeffs[i] = (c[i + 1] - c[i]) / (3 * h[i])

    # Вычисляем значения сплайна на каждом интервале
    spline_values = np.zeros_like(x_dense)
    for i in range(n):
        mask = (x_dense >= x_nodes[i]) & (x_dense <= x_nodes[i + 1])
        dx = x_dense[mask] - x_nodes[i]
        spline_values[mask] = (
            a_coeffs[i] + b_coeffs[i] * dx + c[i] * dx**2 + d_coeffs[i] * dx**3
        )

    return spline_values

# Узлы и значения для первой задачи (f(x) = |x|)
n = int(input("Введите число узлов интерполяции n: "))
x_nodes_1 = np.linspace(-1, 1, n)
y_nodes_1 = np.abs(x_nodes_1)

# Узлы и значения для второй задачи
x_nodes_2 = np.array([-1, 0, 2, 3, 5])
y_nodes_2 = np.array([1, 2, 4, 1, -3])

# Генерация точек для графика
x_dense_1 = np.linspace(-1, 1, 500)
y_dense_1 = np.abs(x_dense_1)
y_spline_1 = cubic_spline_interpolation(x_nodes_1, y_nodes_1, x_dense_1)

x_dense_2 = np.linspace(-1, 5, 500)
y_spline_2 = cubic_spline_interpolation(x_nodes_2, y_nodes_2, x_dense_2)

# Построение графиков
plt.figure(figsize=(12, 6))

# Первый график: f(x) = |x|
plt.subplot(1, 2, 1)
plt.plot(x_dense_1, y_dense_1, label='|x| (точная функция)', color='blue', linewidth=2)
plt.plot(x_dense_1, y_spline_1, label='Кубический сплайн', color='red', linestyle='--', linewidth=2)
plt.scatter(x_nodes_1, y_nodes_1, color='black', label='Узлы интерполяции', zorder=5)
plt.title('Интерполяция |x| кубическим сплайном', fontsize=14)
plt.xlabel('x', fontsize=12)
plt.ylabel('y', fontsize=12)
plt.legend(fontsize=10)
plt.grid(True)

# Второй график: интерполяция заданных точек
plt.subplot(1, 2, 2)
plt.plot(x_dense_2, y_spline_2, label='Кубический сплайн', color='green', linestyle='--', linewidth=2)
plt.scatter(x_nodes_2, y_nodes_2, color='black', label='Узлы интерполяции', zorder=5)
plt.title('Интерполяция заданных точек', fontsize=14)
plt.xlabel('x', fontsize=12)
plt.ylabel('y', fontsize=12)
plt.legend(fontsize=10)
plt.grid(True)

# Сохранение и отображение графиков
plt.tight_layout()
plt.show()
