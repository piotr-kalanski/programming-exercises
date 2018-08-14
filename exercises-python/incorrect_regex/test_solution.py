from incorrect_regex.solution import solve
import unittest


class SolutionTests(unittest.TestCase):

    def test1(self):
        self.__run_test(
            [
                True,
                False
            ],
            [
                ".*\+",
                ".*+"
            ]
        )

    def __run_test(self, expected_output, regex_patterns):
        # run solution
        output = solve(regex_patterns)

        # check that output is equal to expected output
        self.assertEqual(expected_output, output)
