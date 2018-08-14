from solution import solve
import unittest


class SolutionTests(unittest.TestCase):

    def test1(self):
        self.__run_test(
            False,
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23, 45, 84, 78},
            [
                {1, 2, 3, 4, 5},
                {100, 11, 12}
            ]
        )

    def __run_test(self, expected_output, english_students, french_students):
        # run solution
        output = solve(english_students, french_students)

        # check that output is equal to expected output
        self.assertEqual(expected_output, output)