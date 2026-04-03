import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EquipmentService, Equipment } from '../../services/equipment.service';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, LucideAngularModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  statsCards = [
    { title: 'Total de Equipos', key: 'total', icon: 'layout-dashboard', color: 'indigo', gradient: 'from-indigo-500/10 to-violet-500/10', iconColor: 'text-indigo-500' },
    { title: 'En Operación', key: 'operativo', icon: 'check-circle', color: 'emerald', gradient: 'from-emerald-500/10 to-green-500/10', iconColor: 'text-emerald-500' },
    { title: 'En Mantenimiento', key: 'mantenimiento', icon: 'wrench', color: 'amber', gradient: 'from-amber-500/10 to-orange-500/10', iconColor: 'text-amber-500' },
    { title: 'Fuera de Servicio', key: 'fueraServicio', icon: 'x-circle', color: 'red', gradient: 'from-red-500/10 to-rose-500/10', iconColor: 'text-red-500' }
  ];

  stats: any = {
    total: 0,
    operativo: 0,
    mantenimiento: 0,
    fueraServicio: 0
  };
  loading = true;

  constructor(private equipmentService: EquipmentService) {}

  ngOnInit(): void {
    this.equipmentService.getAll().subscribe({
      next: (data) => {
        this.stats.total = data.length;
        this.stats.operativo = data.filter(e => e.estado === 'OPERATIVO').length;
        this.stats.mantenimiento = data.filter(e => e.estado === 'MANTENIMIENTO').length;
        this.stats.fueraServicio = data.filter(e => e.estado === 'FUERA_SERVICIO').length;
        this.loading = false;
      },
      error: () => this.loading = false
    });
  }
}
