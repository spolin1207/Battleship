# Provided an integer N, print a list of all numbers <= N, replacing multiples of 3 with "fizz",
# multiples of 5 with "buzz", and multiples of both 3 and 5 with "fizzbuzz"
# Example 1:
#     Input: 15
#     Output: 1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz


def fizz_buzz(lst):
    for i in range(len(lst)):
        if lst[i] % 3 == 0 and lst[i] % 5 == 0:
            lst[i] = "fizzbuzz"
        elif lst[i] % 3 == 0:
            lst[i] = "fizz"
        elif lst[i] % 5 == 0:
            lst[i] = "buzz"
    print(lst)
    return lst


fizz_buzz([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15])
