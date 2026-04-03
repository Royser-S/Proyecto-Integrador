import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import { LucideAngularModule } from 'lucide-angular';
import { MaintenanceService, Maintenance } from '../../services/maintenance.service';
import { EquipmentService, Equipment } from '../../services/equipment.service';

@Component({
  selector: 'app-maintenance-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, LucideAngularModule],
  templateUrl: './maintenance-form.component.html',
  styleUrl: './maintenance-form.component.css'
})
export class MaintenanceFormComponent implements OnInit {
  maintenance: Maintenance = {
    equipment: {} as Equipment,
    fecha: new Date().toISOString().split('T')[0],
    responsable: '',
    tipoMantenimiento: 'PREVENTIVO',
    descripcion: '',
    estado: 'PENDIENTE'
  };
  equipments: Equipment[] = [];
  isEdit = false;
  loading = false;

  constructor(
    private maintenanceService: MaintenanceService,
    private equipmentService: EquipmentService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadEquipments();
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.isEdit = true;
      this.loadMaintenance(id);
    }
  }

  loadEquipments(): void {
    this.equipmentService.getAll().subscribe(data => {
      this.equipments = data;
    });
  }

  loadMaintenance(id: number): void {
    this.loading = true;
    this.maintenanceService.getById(id).subscribe({
      next: (data) => {
        this.maintenance = data;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
        this.router.navigate(['/mantenimientos']);
      }
    });
  }

  onSubmit(): void {
    if (this.isEdit && this.maintenance.id) {
      this.maintenanceService.update(this.maintenance.id, this.maintenance).subscribe(() => {
        this.router.navigate(['/mantenimientos']);
      });
    } else {
      this.maintenanceService.create(this.maintenance).subscribe(() => {
        this.router.navigate(['/mantenimientos']);
      });
    }
  }

  compareEquipments(e1: Equipment, e2: Equipment): boolean {
    return e1 && e2 ? e1.id === e2.id : e1 === e2;
  }

  cancel(): void {
    this.router.navigate(['/mantenimientos']);
  }
}
