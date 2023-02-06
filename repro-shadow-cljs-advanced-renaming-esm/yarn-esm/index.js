export function callDogBark(dog, n) {
  // The for loop is to prevent the function from being inlined.
  for (let i = 0; i < n; i++) {
    dog.bark();
  }
}
