from solution import solve
import unittest


class SolutionTests(unittest.TestCase):

    def test1(self):
        self.__run_test(
            38,
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 24, 52},
            [
                ("intersection_update", {2, 3, 5, 6, 8, 9, 1, 4, 7, 11}),
                ("update", {55, 66}),
                ("symmetric_difference_update", {22, 7, 35, 62, 58}),
                ("difference_update", {11, 22, 35, 55, 58, 62, 66})
            ]
        )

    def __run_test(self, expected_output, set_a: set, operations):
        # run solution
        output = solve(set_a, operations)

        # check that output is equal to expected output
        self.assertEqual(expected_output, output)
