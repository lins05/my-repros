function callDogBark(dog, n) {
  for (let i = 0; i < n; i++) {
    dog.bark();
  }
}

exports.callDogBark = callDogBark;
