import { TestBed } from '@angular/core/testing';

import { ActivarCuentaenService } from './activar-cuentaen.service';

describe('ActivarCuentaenService', () => {
  let service: ActivarCuentaenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActivarCuentaenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
