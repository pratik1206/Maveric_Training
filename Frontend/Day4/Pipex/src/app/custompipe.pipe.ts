import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'custompipe'
})
export class CustompipePipe implements PipeTransform {

  // transform(value: string, ...args: unknown[]): unknown {
  //   console.log("VALUE :- "+value)
  //   console.log("ARGS"+args)
  //   let newStr: string = "";
  //   for (var i = value.length - 1; i >= 0; i--) {
  //     let cap = value.charAt(0).toUpperCase;
  //     newStr += value.charAt(i);
  //   }
  //   return newStr;
  // }


  // transform(value: string, ...args: unknown[]): unknown {
  //   console.log("VALUE :- "+value)
  //   console.log("ARGS"+args)
  //   let newStr: string = "";
  //   if (value.length === 0) {
  //     return value;
  //   }
  
  //   const firstLetter = value.charAt(0).toUpperCase();
  //   const lastLetter = value.charAt(value.length - 1).toUpperCase();
  
  //   newStr = firstLetter + value.slice(1, -1) + lastLetter;
  
  //   return newStr;
  // }

  // transform(value: string, ...args: unknown[]): unknown {
  //   console.log("VALUE :- "+value)
  //   console.log("ARGS"+args)
  //   let newStr: string = "";
  //   for  (var i =0 ; i <=value.length ; i++)  {
  //     if (i == 0 || i == value.length - 1){
  //       newStr += value.charAt(i).toUpperCase();
  //       console.log(newStr);}
  //     else{
  //     newStr += value.charAt(i);
  //     }
  //   }
  //  return newStr;

  //   }

  transform(value: String, ...args: unknown[]): unknown {
    let newStr: string = "";
    let first: string = "";
    let last: string = "";
    let final: string = "";
    for (var i = 0; i <= value.length - 1; i++) {
      if(i==0){
        first=value.charAt(i).toUpperCase()
      }
      else if(i==value.length - 1){
        last=value.charAt(i).toUpperCase()
      }
      else{
        newStr += value.charAt(i);
      }
      final=first+newStr+last;
    }
    return final;
  }
}
