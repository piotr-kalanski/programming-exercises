import unittest
from basic_data_types.lists.solution import solve


class SolutionTests(unittest.TestCase):

    def test1(self):
        self.__run_test(
            [
                [6, 5, 10],
                [1, 5, 9, 10],
                [9, 5, 1]
            ],
            [
                "insert 0 5",
                "insert 1 10",
                "insert 0 6",
                "print",
                "remove 6",
                "append 9",
                "append 1",
                "sort",
                "print",
                "pop",
                "reverse",
                "print"
            ]
        )

    def __run_test(self, expected_output, commands):
        # run solution
        output = solve(commands)

        # check that output is equal to expected output
        self.assertEqual(expected_output, output)
