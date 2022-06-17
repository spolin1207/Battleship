# Provided the String N, determine if the string is a palindrome (the same backwards as forwards).
# Example 1:
#     Input: noon
#     Output: true
# Example 2:
#     Input: apple
#     Output: false

def isPalindrome(n):
    if n == n[::-1]:
        print("Palndrome!")
    else:
        print("Not Palindrome!")


def isPal(str):
    palindrome = True
    for i in range(len(str) // 2):
        if str[i] != str[len(str) - i - 1]:
            palindrome = False

    print(palindrome)
    return palindrome


isPal('asdkjgje')
