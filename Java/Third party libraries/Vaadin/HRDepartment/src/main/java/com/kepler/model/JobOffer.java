package com.kepler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;                    // ФИО
    private String jobTitle;                    // Наименование вакансии
    private String department;                  // Подразделение
    private String address;                     // Адрес
    private String workingConditionsClass;      // Класс условий труда
    private String workSchedule;                // График работы
    private String irregularWorkingHours;       // Ненормированный рабочий день (да/нет)
    private String hireDate;                    // Дата приема
    private String salaryNet;                   // Заработная плата на руки
    private String salaryGross;                 // Заработная плата (оклад/премия) к начислению
    private String housingCompensation;         // Компенсация жилья
    private String recruitmentResponsible;      // Ответственный за подбор
    private String offerDate;                   // Дата предложения
    private String manager;                     // Руководитель
    private String recommendedBy;               // Кем рекомендован
    private String changedInSHR;                // Изменено в ШР
}
