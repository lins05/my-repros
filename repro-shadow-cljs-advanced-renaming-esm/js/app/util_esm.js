import moment from "moment";

export const foo = 1;

export function reportNow() {
  console.log(moment(moment.now()));
}

export function callDogBark(dog, n) {
  for (let i = 0; i < n; i++) {
    dog.bark();
  }
}
