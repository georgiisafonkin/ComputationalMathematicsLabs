import numpy as np


class TridiagonalSolver:

    def __init__(self, n: int, eps: float = None, gamma: int = None) -> None:
        """
        Initialize the system with matrix A and vector f.

        Parameters:
        n (int): Size of the matrix and vector.
        eps (float, optional): Perturbation parameter for vector f.
        gamma (int, optional): Modifier for the matrix diagonal and f vector.
        """
        if n <= 0:
            raise ValueError("Matrix size 'n' must be greater than 0.")
        self.n = n
        self.matrix = self._construct_matrix(n, gamma)
        self.f = self._construct_rhs(n, eps, gamma)

    @staticmethod
    def _construct_matrix(n: int, gamma: int = None) -> np.ndarray:
        """Construct the tridiagonal matrix A."""
        matrix = np.zeros((n, n))
        for i in range(n):
            matrix[i, i] = (2 * (i + 1) + gamma if gamma is not None else 2)
        for i in range(n - 1):
            matrix[i, i + 1] = matrix[i + 1, i] = -1
        return matrix

    @staticmethod
    def _construct_rhs(n: int, eps: float = None, gamma: int = None) -> np.ndarray:
        """Construct the right-hand side vector f."""
        if gamma is not None:
            return np.array([2 * (i + 2) + gamma for i in range(n)])
        return np.full(n, 2 + (eps if eps is not None else 0))

    def print_matrix(self) -> None:
        """Print the matrix A."""
        print("Matrix A:")
        print(self.matrix)

    def print_rhs(self) -> None:
        """Print the vector f."""
        print("Vector f:")
        print(" ".join(f"{value:.6f}\n" for value in self.f))

    def solve(self) -> np.ndarray:
        """
        Solve the tridiagonal system Ax = f using the Thomas algorithm.

        Returns:
        np.ndarray: Solution vector x.
        """
        n = self.n
        a = np.zeros(n - 1)  # Sub-diagonal
        b = self.matrix.diagonal()  # Main diagonal
        c = np.zeros(n - 1)  # Super-diagonal

        for i in range(n - 1):
            a[i] = self.matrix[i + 1, i]
            c[i] = self.matrix[i, i + 1]

        alpha = np.zeros(n)
        beta = np.zeros(n)

        # Forward sweep
        alpha[0] = -c[0] / b[0]
        beta[0] = self.f[0] / b[0]
        for i in range(1, n - 1):
            denominator = b[i] + alpha[i - 1] * a[i - 1]
            alpha[i] = -c[i] / denominator
            beta[i] = (self.f[i] - beta[i - 1] * a[i - 1]) / denominator
        beta[n - 1] = (self.f[n - 1] - beta[n - 2] * a[n - 2]) / (b[n - 1] + alpha[n - 2] * a[n - 2])

        # Back substitution
        x = np.zeros(n)
        x[-1] = beta[-1]
        for i in range(n - 2, -1, -1):
            x[i] = alpha[i] * x[i + 1] + beta[i]

        return x

    def run_and_print(self) -> None:
        """Solve the system and print the solution."""
        solution = self.solve()
        print("Solution vector X:")
        print(" ".join(f"{value:.6f}\n" for value in solution))


def main():
    n = 4
    eps = 1e-5
    gamma = 9

    solver = TridiagonalSolver(n, eps, gamma)
    solver.print_matrix()
    solver.print_rhs()
    solver.run_and_print()


if __name__ == "__main__":
    main()
