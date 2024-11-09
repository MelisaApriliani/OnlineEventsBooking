export interface BusinessEntity {
    businessId: number;
    businessEntityName: string;
    role: ROLE;
};

export enum ROLE {
    USER = "USER",    
    ADMIN = "ADMIN",  
}