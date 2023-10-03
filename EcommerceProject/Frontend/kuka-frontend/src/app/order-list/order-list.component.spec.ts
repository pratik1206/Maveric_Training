import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
// import { OrderService } from './order.service.ts';
import { OrderService } from '../order.service';

describe('OrderService', () => {
  let orderService: OrderService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [OrderService]
    });

    orderService = TestBed.inject(OrderService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(orderService).toBeTruthy();
  });

  it('should retrieve orders', () => {
    const mockResponse = [{ id: 1, name: 'Order 1' }, { id: 2, name: 'Order 2' }];

    orderService.getOrders().subscribe(data => {
      expect(data).toEqual(mockResponse);
    });

    const req = httpTestingController.expectOne('http://localhost:8080/order/retrieve/user/10');
    expect(req.request.method).toBe('GET');

    req.flush(mockResponse);
    httpTestingController.verify();
  });
});
