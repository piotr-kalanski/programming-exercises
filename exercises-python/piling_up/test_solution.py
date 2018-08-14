from piling_up.solution import solve
import unittest


class SolutionTests(unittest.TestCase):

    def test1(self):
        self.__run_test(
            [
                True,
                False
            ],
            [
                [4, 3, 2, 1, 3, 4],
                [1, 3, 2]
            ]
        )

    def __run_test(self, expected_output, cubes_stacks):
        # run solution
        output = solve(cubes_stacks)

        # check that output is equal to expected output
        self.assertEqual(expected_output, output)
