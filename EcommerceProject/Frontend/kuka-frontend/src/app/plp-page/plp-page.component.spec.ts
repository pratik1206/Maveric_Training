import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PLPPageComponent } from './plp-page.component';

describe('PLPPageComponent', () => {
  let component: PLPPageComponent;
  let fixture: ComponentFixture<PLPPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PLPPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PLPPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
