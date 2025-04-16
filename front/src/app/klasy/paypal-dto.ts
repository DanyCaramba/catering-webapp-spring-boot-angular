export class PaypalDTO {
    total: number;
    currency: string;
    method: string;
    intent: string;
  
    constructor(total:number) {
      this.total = total;    
      this.currency = 'USD'; 
      this.method = 'paypal';
      this.intent = 'sale';   
    }
  }
  