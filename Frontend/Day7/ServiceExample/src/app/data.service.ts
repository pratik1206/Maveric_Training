import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  name: string=""
  constructor() { }

  setName(name: string) {
    console.log("setName from Data.service is called")
    this.name=name;
  }

  getName(){
    console.log("getName from Data.service is called")
    return this.name;
  }
}
